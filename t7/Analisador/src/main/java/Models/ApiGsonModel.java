package Models;

import com.google.gson.*;
import java.io.IOException;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class ApiGsonModel {

    public void GetCommitList(String urlRepo, RepoCommitModel model) throws FileNotFoundException, IOException {
        String urlAux = urlRepo.substring(urlRepo.lastIndexOf(".") + 4);
        String urlCommits = "https://api.github.com/repos" + urlAux + "/commits";
        String urlstr = "https://api.github.com/repos/google/gson/commits";
        URL url = new URL(urlstr);
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
        JsonArray results = parser.parse(in.readLine()).getAsJsonArray();

        ArrayList<CommitModel> commits = new ArrayList<>();
        for (JsonElement e : results) {
            CommitModel commit = new CommitModel(
                e.getAsJsonObject().get("commit").getAsJsonObject().get("message").toString(),
                e.getAsJsonObject().get("commit").getAsJsonObject().get("author").getAsJsonObject().get("date").toString()
            );
            commits.add(commit);
        }
        model.settListCommits(urlRepo, commits);
        in.close();
    }
}
