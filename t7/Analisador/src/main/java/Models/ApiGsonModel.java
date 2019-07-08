package Models;

import com.google.gson.*;
import java.io.IOException;
import java.io.*;
import java.net.*;
import java.text.ParseException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ApiGsonModel {

    private RepoCommitModel model;
    private String urlRepo;
    private int indice;

    public ApiGsonModel() {
        this.indice = -1;
    }

    public RepoCommitModel getModel() {
        return model;
    }

    public void setModel(RepoCommitModel model) {
        this.model = model;
    }

    public String getUrlRepo() {
        return urlRepo;
    }

    public void setUrlRepo(String urlRepo) {
        this.urlRepo = urlRepo;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

//    @Override
//    public void run() {
//        try {
//            RequestGitHub();
//        } catch (IOException ex) {
//            System.out.println("Erro ao realizar requisição");
//        } catch (ParseException ex) {
//            Logger.getLogger(ApiGsonModel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
    public void GetCommitList() throws FileNotFoundException, IOException {
        String urlAux = urlRepo.substring(urlRepo.lastIndexOf(".") + 4);
        String urlCommits = "https://api.github.com/repos" + urlAux + "/commits";
        JsonArray results;
        int current = 1;
        do {
            urlAux = urlCommits + "?page=" + current;
            URL url = new URL(urlAux);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            System.out.println("Response code: " + con.getResponseCode());

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));

            //Response header (includes pagination links)
            System.out.println(con.getHeaderFields().get("Link").get(0));

            // Parse a nested JSON response using Gson
            JsonParser parser = new JsonParser();
            results = parser.parse(in.readLine()).getAsJsonArray();

            ObservableList<CommitModel> commits = FXCollections.observableArrayList();
            for (JsonElement e : results) {
                CommitModel commit = new CommitModel(
                        e.getAsJsonObject().get("commit").getAsJsonObject().get("message").toString(),
                        e.getAsJsonObject().get("commit").getAsJsonObject().get("author").getAsJsonObject().get("date").toString()
                );
                commits.add(commit);
            }
            
            model.settListCommits(urlRepo, commits);
            current++;
            in.close();
        } while (!results.isJsonNull());
    }

    public void RequestGitHub() throws IOException, ParseException {
        JsonArray results;
        int currentPage = 1;

        String urlAux = urlRepo.substring(urlRepo.lastIndexOf(".") + 4);
        String urlCommits = "https://api.github.com/repos" + urlAux + "/commits";
        System.out.println(urlCommits);
        do {
            String urlPag = urlCommits + "?page=" + currentPage;

            System.out.println(urlPag);

            URL url = new URL(urlPag);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

            // Parse a nested JSON response using Gson
            JsonParser parser = new JsonParser();
            results = parser.parse(in.readLine()).getAsJsonArray();

            ObservableList<CommitModel> commits = FXCollections.observableArrayList();
            for (JsonElement e : results) {
                CommitModel commit = new CommitModel(
                        e.getAsJsonObject().get("commit").getAsJsonObject().get("message").toString(),
                        e.getAsJsonObject().get("commit").getAsJsonObject().get("author").getAsJsonObject().get("date").toString()
                );
                commits.add(commit);
            }
            model.settListCommits(urlRepo, commits);
            in.close();
            currentPage++;
        } while (results.size() >= 30);
        //conditionSignal(); // Avisa que acabou a thread
    }

    public synchronized void conditionSignal() {
        notifyAll();
    }

    public synchronized void conditionWait() {
        try {
            wait();
        } catch (InterruptedException e) {
        }
    }
}
