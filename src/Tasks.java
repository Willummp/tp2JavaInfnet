import java.time.LocalDate;

class Tasks {
    private String title;
    private String description;
    private LocalDate creationDate;
    private LocalDate completionDate;
    private boolean completed;

    public Tasks(String title, String description) {
        this.title = title;
        this.description = description;
        this.creationDate = LocalDate.now();
        this.completed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public LocalDate getCompletionDate() {
        return completionDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markAsCompleted() {
        this.completed = true;
        this.completionDate = LocalDate.now();
    }
}