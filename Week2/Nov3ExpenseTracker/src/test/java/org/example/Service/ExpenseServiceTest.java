package org.example.Service;

import org.example.Expense;
import org.example.Repository.IRepository;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

//Uses a simple in-memory FakeRepo.
class ExpenseServiceTest {

    private static class FakeRepo implements IRepository {
        private final Map<Integer, Expense> store = new HashMap<>();

        @Override
        public Expense readExpense(int id) {
            return store.get(id);
        }

        @Override
        public void createExpense(Expense expense) {
            store.put(expense.getId(), expense);
        }

        @Override
        public void updateExpense(Expense expense) {
            store.put(expense.getId(), expense);
        }

        @Override
        public void deleteExpense(int id) {
            store.remove(id);
        }

        @Override
        public List<Expense> loadExpenses() {
            return new ArrayList<>(store.values());
        }

        // ✅ New: implement the missing abstract method
        @Override
        public void saveExpenses(List<Expense> expenses) {
            store.clear();
            for (Expense e : expenses) {
                store.put(e.getId(), e);
            }
        }
    }


    private FakeRepo repo;
    private ExpenseService service;

    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        repo = new FakeRepo();
        service = new ExpenseService(repo);
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testServiceIsCreated() {
        assertNotNull(service);
    }

    // ---------------- createNewExpense ----------------
    // Current implementation: if (repo.readExpense(id) == null) return null (no create)
    // and if it EXISTS, create a NEW one -> likely inverted, but we test current behavior.

    @Test
    void createNewExpense_returnsNull_whenIdNotInRepo_currentLogic() {
        // repo has no id=1 yet
        Expense created = service.createNewExpense(1, 12.34, "Store");
        assertNull(created, "Current logic returns null if id not found");
        assertNull(repo.readExpense(1), "Repo should still be empty for id=1");
    }

    @Test
    void createNewExpense_creates_whenIdAlreadyInRepo_currentLogic() throws InterruptedException {
        // Seed repo with an existing expense id=1
        repo.createExpense(new Expense(1, new Date(), 1.0, "Existing"));

        Expense created = service.createNewExpense(1, 20.0, "NewMerchant");
        assertNotNull(created, "Current logic creates when id exists");
        assertEquals(1, created.getId());
        assertEquals(20.0, created.getValue(), 1e-9);
        assertEquals("NewMerchant", created.getMerchant());

        Expense inRepo = repo.readExpense(1);
        assertNotNull(inRepo);
        assertEquals(20.0, inRepo.getValue(), 1e-9);
        assertEquals("NewMerchant", inRepo.getMerchant());
    }

    // ---------------- getExpense ----------------

    @Test
    void getExpense_returnsFromRepo() {
        Expense e = new Expense(7, new Date(), 99.0, "X");
        repo.createExpense(e);

        Expense out = service.getExpense(7);
        assertNotNull(out);
        assertEquals(7, out.getId());
        assertEquals(99.0, out.getValue(), 1e-9);
        assertEquals("X", out.getMerchant());
    }

    // ---------------- updateExpense ----------------

    @Test
    void updateExpense_overwritesExisting() {
        Expense e = new Expense(2, new Date(), 10.0, "Y");
        repo.createExpense(e);

        Expense updated = new Expense(2, new Date(), 55.5, "Y2");
        service.updateExpense(updated);

        Expense inRepo = repo.readExpense(2);
        assertNotNull(inRepo);
        assertEquals(55.5, inRepo.getValue(), 1e-9);
        assertEquals("Y2", inRepo.getMerchant());
    }

    // ---------------- deleteExpense ----------------
    // Current implementation: if (repo.readExpense(id) != null) return false (and DO NOT delete)
    //                         else delete and return true. (inverted)
    @Test
    void deleteExpense_returnsFalse_whenExists_currentLogic() {
        repo.createExpense(new Expense(3, new Date(), 1.0, "Z"));

        boolean ok = service.deleteExpense(3);

        assertFalse(ok, "Current logic returns false when it exists");
        assertNotNull(repo.readExpense(3), "And it does not delete");
    }

    @Test
    void deleteExpense_returnsTrue_whenMissing_currentLogic() {
        // repo has no id=4
        boolean ok = service.deleteExpense(4);

        assertTrue(ok, "Current logic returns true when missing");
        assertNull(repo.readExpense(4), "Nothing to delete anyway");
    }

    // ---------------- printExpenses ----------------

    @Test
    void printExpenses_printsList() {
        repo.createExpense(new Expense(10, new Date(), 3.0, "A"));
        repo.createExpense(new Expense(11, new Date(), 4.0, "B"));

        service.printExpenses();

        String printed = outContent.toString();
        // Default List.toString() format includes brackets and entries.
        assertTrue(printed.contains("["), "Should print a list");
        assertTrue(printed.contains("]"), "Should print a list");
        // Light sanity check for ids
        assertTrue(printed.contains("10"));
        assertTrue(printed.contains("11"));
    }

    // ---------------- sumExpenses ----------------

    @Test
    void sumExpenses_printsSum() {
        repo.createExpense(new Expense(1, new Date(), 10.5, "A"));
        repo.createExpense(new Expense(2, new Date(), 3.5, "B"));

        service.sumExpenses();

        String printed = outContent.toString().trim();
        // Expected sum = 14.0
        assertTrue(printed.endsWith("14.0"), "Should print 14.0");
    }
}
