package Models;

import java.util.ArrayList;
import java.util.HashMap;


public class RepoCommitModel {
    public HashMap<String, ArrayList<CommitModel>> repository;

    public RepoCommitModel() {
        this.repository = new HashMap<>();
    }

    public HashMap<String, ArrayList<CommitModel>> getRepository() {
        return repository;
    }

    public void setRepository(HashMap<String, ArrayList<CommitModel>>  repository) {
        this.repository =  repository;
    }
    
    public ArrayList<CommitModel> getListCommits(String repository) {
        return this.repository.get(repository);
    }
    
    public void settListCommits(String key, ArrayList<CommitModel> listCommits) {
        this.repository.put(key, listCommits);
    }
}
