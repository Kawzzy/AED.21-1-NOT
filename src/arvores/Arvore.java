package arvores;

public class Arvore<T> {
	private NoArvore<T> raiz;
	private int inc = 1;
	private static int maiorAltura = 0;
    private static int menorAltura = 0;
	
	public Arvore() {
		super();
		this.raiz = null;
	}

	public NoArvore<T> getRaiz() {
		return raiz;
	}

	public void setRaiz(NoArvore<T> raiz) {
		if (raiz != null) {
			this.raiz = raiz;
		}
	}

	public boolean vazia() {
		return (this.raiz == null);
	}

	public String toString() {
		if (this.vazia()) {
			return "<>";
		} else {
			return this.raiz.imprimePre();
		}
	}
	
	public NoArvore<T> pertence(T procurado){
		if (this.vazia()) {
			return null;
		} else {
			return this.raiz.pertence(procurado);
		}
	}
	
	public int getAltura() {
		if (this.vazia()) {
			return -1;
		} else {
			//Segue caso a raiz possua filho, caso contrário retorna zero
			if (this.getRaiz().getFilho() != null) {
				NoArvore<T> filho = this.getRaiz().getFilho();
				return filho.getAlturaArvore(filho, inc);
			}
			return 0;
		}
	}
	 
	public int getNivel(T info) {
		if (this.vazia()) {
			return -1;
		}
        return raiz.alturaNo(info, 0);
    }
	
	public boolean isBalanceada() {
        if (this.vazia()) {
            return false;
        }
        maiorAltura = getAltura();
        menorAltura = getMenorAltura();

        if (maiorAltura - 1 == menorAltura || maiorAltura == menorAltura) {
            return true;
        }
        return false;
    }
	
	public int getMenorAltura() {
        if (this.vazia()) {
            return -1;
        } else {
            //Segue caso a raiz possua filho, caso contrário retorna zero
            if (this.getRaiz().getFilho() != null) {
                NoArvore<T> filho = this.getRaiz().getFilho();
                return filho.getMenorAlturaArvore(filho, inc);
            }
            return 0;
        }
    }
	
	public String imprimePosOrdem() {
		if (this.vazia()) {
			return "";
		} else {
			NoArvore<T> filho = this.getRaiz().getFilho();
			if (filho != null) {
				return this.getRaiz().imprimePosOrdem(filho) + this.raiz.getInfo() + ";";
			}
			return "" + getRaiz().getInfo() + ";";
		}
	}
	
	public int getQuantidadeDeNosFolha() {
		if (this.vazia()) {
            return -1;
		}else {
		  if (this.getRaiz().getFilho() != null) {
			  NoArvore<T> filho = this.getRaiz().getFilho();
			  return this.raiz.getQuantidadeDeNosFolha(filho,1);
			  }
		  return 0;
		  }
	  }
}