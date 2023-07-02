package views;

public class MenuView {
    public static  String montarMenuPrincipal() {
        StringBuilder builder = new StringBuilder();
        builder.append("=========================RAVIN========================= \n");
        builder.append("1 - Funcionário \n");
        builder.append("2 - Cliente \n");
        builder.append("3 - Produto \n");
        builder.append("4 - Cardapio \n");
        builder.append("5 - Mesa \n");
        builder.append("6 - Pedido \n");
        builder.append("7 - Sair \n");

        return builder.toString();
    }

    public static String montarSubMenuGeral(String modulo) {
        StringBuilder builder = new StringBuilder();
        builder.append("========================Gestão de ");
        builder.append(modulo);
        builder.append("======================== \n");
        builder.append("1 - Cadastrar \n");
        builder.append("2 - Alterar \n");
        builder.append("3 - Excluir \n");
        builder.append("4 - Consultar \n");
        builder.append("5 - Listar todos \n");

        return builder.toString();
    }
}
