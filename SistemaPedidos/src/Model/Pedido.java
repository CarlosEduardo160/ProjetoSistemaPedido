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

    public boolean pagar(){
        if(status == StatusPedido.PENDENTE){
            status = StatusPedido.PAGO;
            return true;
        }
        return false;
    }

    public boolean enviar(){
        if(status == StatusPedido.PAGO){
            status = StatusPedido.ENVIADO;
            return true;
        }
        return false;
    }

    public boolean cancelar(){
        if(status == StatusPedido.PENDENTE){
            status = StatusPedido.CANCELADO;
            return true;
        }
        return false;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public StatusPedido getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return String.format(
                "-----PEDIDO #%d-----%n" +
                        "Comprador| %s%n" +
                        "Produto| %s%n" +
                        "Status: %s%n" +
                        "----------", idPedido, cliente, produto, status
        );
    }
}
