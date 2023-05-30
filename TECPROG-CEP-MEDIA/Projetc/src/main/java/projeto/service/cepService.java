package projeto.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import projeto.model.endereco;

@Service
public class cepService {

    public endereco findEnderecoByCEP(String cep) throws IOException, InterruptedException {

        String Url = "http://viacep.com.br/ws/" + cep + "/json";
        URI endereco = URI.create(Url);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String enderecoJsonEmString = response.body();

        return new Gson().fromJson(enderecoJsonEmString, endereco.class);

    }
}
