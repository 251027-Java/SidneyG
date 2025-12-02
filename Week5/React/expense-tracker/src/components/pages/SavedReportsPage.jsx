import SavedReportsList from "./../SavedReportsList";

const SavedReportsList = (savedReports, deleteReportHandler) => {
    return(
        <div>
            <h1>Saved Reports</h1>
            <SavedReportsList
                reports={savedReports} 
                onDelete={deleteReportHandler}/>
        </div>
    );
};

export default SavedReportsList;