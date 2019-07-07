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
            newArray.add("Data: " + commit.getData() + " | " + "Mensagem: " + commit.getMessage());
            System.out.println("Data: " + commit.getData() + " | " + "Mensagem: " + commit.getMessage());
        }
        return newArray;
    }

    public void settListCommits(String key, ObservableList<CommitModel> listCommits) {
        this.repository.put(key, listCommits);
    }
}
