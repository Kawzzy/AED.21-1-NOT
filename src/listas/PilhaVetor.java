package listas;

public class PilhaVetor<T> implements Pilha<T> {
// Daniel Busarello
	private T[] data;
	private int limit;
	private int size;

	public PilhaVetor(int limit) {
		this.limit = limit;
		data = (T[]) new Object[limit];
	}

	@Override
	public void push(T data) {
		if (size < limit) {
			this.data[size] = data;
			size++;
		} else {
			throw new IndexOutOfBoundsException("Limite m?ximo da pilha alcan?ado");
		}

	}

	@Override
	public T pop() {
		T temp = this.peek();
		size--;
		this.data[size] = null;
		return temp;
	}

	@Override
	public T peek() {
		if (this.estaVazia()) {
			throw new IndexOutOfBoundsException("Pilha vazia");
		}
		return this.data[size-1];
	}

	@Override
	public boolean estaVazia() {
		if (size == 0)
			return true;
		return false;
	}

	@Override
	public void liberar() {
		this.data = (T[]) new Object[limit];
		this.size = 0;
	}

	public String toString() {
		String str = "[base=";
		for (int i=0; i < this.size; i++) {
			str += data[i]+",";
		}
		return str+"=topo]";
	}

	private int getTamanho() {
		return this.size;
	}
	
	private T get(int posicao) {
		return this.data[posicao];
	}
	
	
	// Exerc?cio de revis?o para a prova
	public int compara(PilhaVetor outra) {
		if (this.getTamanho()<outra.getTamanho()) {
			return -1;
		}
		if (this.getTamanho()>outra.getTamanho()) {
			return 1;
		}
		// a partir desse ponto eu sei que as pilhas s?o do mesmo tamanho

		/*
		for (int i=0; i < this.size; i++) {
			if (data[i] != outra.get(i)) {
				return 1;
			}
		}
		return 0;
		*/
		if (this.toString().equals(outra.toString())) {
			return 0;
		}
		else {
			return 1;
		}
	}
}
