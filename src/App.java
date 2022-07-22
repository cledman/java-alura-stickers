import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class App {
    //01:14
    public static void main(String[] args) throws Exception {

        // fazer uma conexão HTTP e buscar os top 250 filmes
        String url = "https://imdb-api.com/en/API/Top250Movies/k_xpvug83y";
        //url="https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060"; // temporária por conta do imdb estar fora do ar


        
        //url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        //ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();
     
        //url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";
        url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD.json";
        ExtratorDeConteudo  extrator = new ExtratorDeConteudoDaNasa();
        
        var http = new ClienteHttp();
        String json = http.buscaDados(url);


        
        //exibir e maniṕular os dados
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var geradora = new GeradorDeFigurinhas();


        for (int i = 0; i < 3; i++) { 

            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";

            geradora.Cria(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();
        }

    }
}
