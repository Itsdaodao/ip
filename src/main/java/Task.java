interface Task {
    String getDescription();
    boolean isDone();
    void markAsDone();
    void markAsNotDone();
    String getStatus();
}
