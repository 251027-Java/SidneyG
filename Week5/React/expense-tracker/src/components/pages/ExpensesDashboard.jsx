import ExpenseFilter from "../ExpenseFilter.jsx";
import ExpenseForm from "../ExpenseForm.jsx";
import ExpenseList from "../ExpenseList.jsx";
import ReportSummary from "../ReportSummary.jsx";

const ExpensesDashboard = () => {
    return (
        <div>
            <div>
                <h1>Expense Dashboard</h1>
            </div>

            <div className=" min-h-screen bg-slate-900 px-4 font-sans">
                <ExpenseFilter
                    selected={filteredYear}
                    onChangeFilter={filterChangeHandler} />
                <ExpenseForm
                    onSaveExpenseData={addExpenseHandler} />
                <ExpenseList
                    items={filteredExpenses}
                    selectedIds={selectedIds}
                    onToggleItem={toggleExpenseHandler}
                    onDelete={deleteExpenseHandler} />
                <ReportSummary
                    selectedExpenses={reportExpenses}
                    onSave={saveReportHandler}
                    closeHandler={() => setSelectedIds([])} />
            </div>
        </div>
    );
};

export default ExpensesDashboard;
