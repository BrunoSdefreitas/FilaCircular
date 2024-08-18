public class FilaCircular {

    private int[] dados;
    private int s_pos;
    private int r_pos;
    private int tamanho;
    private int count;

    public FilaCircular(int tamanho) {
        this.tamanho = tamanho;
        this.dados = new int[tamanho];
        this.s_pos = 0;
        this.r_pos = 0;
        this.count = 0;
    }

    public boolean vazia() {
        return count == 0;
    }

    public boolean cheia() {
        return count == tamanho;
    }

    public void enfileirar(int valor) {
        if (cheia()) {
            System.out.println("Fila cheia!");
            return;
        }
        dados[s_pos] = valor;
        s_pos = (s_pos + 1) % tamanho;
        count++;
        System.out.println(valor + " enfileirado na fila.");
    }

    public int desenfileirar() {
        if (vazia()) {
            System.out.println("Fila vazia!");
            return -1; // Valor para indicar erro
        }
        int valor = dados[r_pos];
        r_pos = (r_pos + 1) % tamanho;
        count--;
        System.out.println(valor + " desenfileirado da fila.");
        return valor;
    }

    public void imprimir() {
        if (vazia()) {
            System.out.println("Fila vazia!");
            return;
        }
        System.out.print("Fila: ");
        for (int i = 0; i < count; i++) {
            System.out.print(dados[(r_pos + i) % tamanho] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        FilaCircular fila = new FilaCircular(5);
        fila.enfileirar(10);
        fila.enfileirar(20);
        fila.enfileirar(30);
        fila.imprimir();

        fila.desenfileirar();
        fila.imprimir();

        fila.enfileirar(40);
        fila.enfileirar(50);
        fila.imprimir();

        fila.enfileirar(60);
        fila.imprimir();
    }
}
