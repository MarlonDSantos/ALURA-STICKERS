import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {


        //Fazer uma conecxão HTTP e buscar 250 top filmes Imdb
        //String url = "https://imdb-api.com/en/API/Top250Movies/k_0ojt0yvm";
        //String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        //String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";

        String url = "http://localhost:8080/linguagens";
        ExtratorConteudo extrator = new ExtratorConteudoIMDB();

        API api = API.IMDB_TOP_SERIES;

        //String url = api.getUrl();
        //ExtratorConteudo extrator = api.getExtrator();

        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        // exibir e manipular os dados
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var geradora = new GeradoraFigurinhas();

        for (int i = 0; i < 3; i++) {

            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.urlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.titulo() + ".png";

            geradora.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.titulo());
            System.out.println();

        //for (Map<String,String> conteudo : listaConteudo) {
            //String urlImage = conteudo.get("image");
            //String titulo = conteudo.get("title");

            //InputStream inputStream = new URL(urlImage).openStream();
            //String nomeArquivo = "saida/" + titulo + ".png";


            //var geradora = new GeradoraFigurinhas();
            //geradora.cria(inputStream,nomeArquivo);

            //System.out.println(conteudo.get(titulo));
            //System.out.println(conteudo.get("image"));
            //System.out.println(conteudo.get("imDbRating"));
            //System.out.println();
        }
    }
}