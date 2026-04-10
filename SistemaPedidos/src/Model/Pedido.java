package Model;

public class Pedido {
    private int idPedido;
    Cliente cliente;
    Produto produto;
    private StatusPedido status = StatusPedido.PENDENTE;

    public Pedido(int idPedido, Cliente cliente, Produto produto){
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.produto = produto;
    }

    public void pagar(){
        if(status == StatusPedido.PENDENTE){
            status = StatusPedido.PAGO;
        }
    }

    public void enviar(){
        if(status == StatusPedido.PAGO){
            status = StatusPedido.ENVIADO;
        }
    }

    public void cancelar(){
        if(status == StatusPedido.PENDENTE){
            status = StatusPedido.CANCELADO;
        }
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void imprimirResumo(){
        System.out.println("Pedido: " + produto.getNome());
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Status: " + status);
    }
}
