package Models;

import java.util.HashMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RepoCommitModel {

    public HashMap<String, ObservableList<CommitModel>> repository;

    public RepoCommitModel() {
        this.repository = new HashMap<>();
    }

    public HashMap<String, ObservableList<CommitModel>> getRepository() {
        return repository;
    }

    public void setRepository(HashMap<String, ObservableList<CommitModel>> repository) {
        this.repository = repository;
    }

    public ObservableList<String> getListCommits(String repository) {
        ObservableList<String> newArray = FXCollections.observableArrayList();
        for (CommitModel commit : this.repository.get(repository)) {
            newArray.add("Data: " + commit.getData() + ": " +commit.getMessage());
            System.out.println("Data: " + commit.getData() + ": " + commit.getMessage());
        }
        return newArray;
    }

    public ObservableList<CommitModel> getListCommitsModel(String repository) {
        return this.repository.get(repository);
    }

    public void settListCommits(String key, ObservableList<CommitModel> listCommits) {
        this.repository.put(key, listCommits);
    }

    public int GetCommitMessageSize(String key) {
        int tam = 0;
        for (CommitModel commit : this.repository.get(key)) {
            tam += commit.getMessage().length();
        }
        return tam/this.repository.get(key).size();
    }
    
    public int GetNumberCommits(String key) {
        return this.repository.get(key).size();
    }
}
