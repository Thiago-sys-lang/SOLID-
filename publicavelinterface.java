// Interface PublicavelInterface
public interface PublicavelInterface {
    void publicar();
}

// Classes concretas de estratégias
class EstrategiaPublicacaoLivro implements PublicavelInterface {
    @Override
    public void publicar() {
        System.out.println("Publicando um livro...");
    }
}

class EstrategiaPublicacaoArtigo implements PublicavelInterface {
    @Override
    public void publicar() {
        System.out.println("Publicando um artigo...");
    }
}

// Classe UsuarioDecorator (ou Autor)
class UsuarioDecorator {
    private PublicavelInterface estrategiaPublicacao;

    // Método para configurar a estratégia
    public void setEstrategiaPublicacao(PublicavelInterface estrategia) {
        this.estrategiaPublicacao = estrategia;
    }

    // Método para realizar a publicação
    public void publicar() {
        if (estrategiaPublicacao == null) {
            System.out.println("Nenhuma estratégia de publicação definida!");
        } else {
            estrategiaPublicacao.publicar();
        }
    }
}

// Classe de teste
public class StrategyPatternTest {
    public static void main(String[] args) {
        // Instância do usuário
        UsuarioDecorator usuario = new UsuarioDecorator();

        // Teste com estratégia de publicação de livro
        usuario.setEstrategiaPublicacao(new EstrategiaPublicacaoLivro());
        usuario.publicar();

        // Teste com estratégia de publicação de artigo
        usuario.setEstrategiaPublicacao(new EstrategiaPublicacaoArtigo());
        usuario.publicar();

        // Teste sem nenhuma estratégia definida
        usuario.setEstrategiaPublicacao(null);
        usuario.publicar();
    }
}
