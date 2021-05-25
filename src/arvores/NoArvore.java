package arvores;

public class NoArvore<T> {
	private T info;
	private NoArvore<T> filho;
	private NoArvore<T> irmao;
	private int altura = 0;
	private static int alturaNo = -1;
	private int menorAltura = 10000;
	private int qtdFolhas = 0;
	private String impressao = "";

	public NoArvore(T info) {
		this.info = info;
		this.filho = null;
		this.irmao = null;
	}

	public String imprimePre() {
		String impressao = "<" + this.info;
		if (this.filho != null) {
			impressao += filho.imprimePre();
		}
		impressao += ">";
		if (this.irmao != null) {
			impressao += irmao.imprimePre();
		}
		return impressao;
	}

	public void inserirFilho(NoArvore<T> no) {
		if (no != null) {
			no.irmao = this.filho;
			this.filho = no;
		}
	}

	public NoArvore<T> pertence(T procurado) {
		NoArvore<T> noBuscado = null;

		if (this.info.equals(procurado)) {
			return this;
		} else {
			if (filho != null)
				noBuscado = this.filho.pertence(procurado);

			if (irmao != null && noBuscado == null) {
				noBuscado = this.irmao.pertence(procurado);
			}
		}

		return noBuscado;
	}
	
	public int getMenorAlturaArvore(NoArvore<T> no, int inc) {
        if (no.getFilho() != null) {
            calculaMenorAltura(no.getFilho(), inc);
        }else {
            if (inc < menorAltura) {
                this.setMenorAltura(inc);
            }
        }

        if (no.getIrmao() != null) {
            getMenorAlturaArvore(no.getIrmao(), inc);
        }

        return this.getMenorAltura(); 
    }

	public int getAlturaArvore(NoArvore<T> no, int inc) {
        if (no.getFilho() != null) {
            calculaAltura(no.getFilho(), inc);
        }

        if (no.getIrmao() != null) {
            getAlturaArvore(no.getIrmao(), inc);
        }

        return altura < inc ? altura = inc : altura; 
    }

    private void calculaAltura(NoArvore<T> no, int inc) {
        inc++;
        getAlturaArvore(no, inc);
    }

    private void calculaMenorAltura(NoArvore<T> no, int inc) {
        inc++;
        getMenorAlturaArvore(no, inc);
    }
	
	public int alturaNo(T info, int inc) {
        if (this.info.equals(info)) {
            alturaNo = inc;
        };

        if (filho != null) {
            auxAlturaNo(filho, inc, info);
        }

        if (irmao != null) {
            irmao.alturaNo(info, inc);
        }

        return alturaNo;
    }

    private void auxAlturaNo(NoArvore<T> filho, int inc, T info) {
        inc++;
        filho.alturaNo(info, inc);
    }
    
    public String imprimePosOrdem(NoArvore<T> no) {
		boolean hasFilho = no.getFilho() != null;
		boolean hasIrmao = no.getIrmao() != null;
		
		if (!hasFilho && !hasIrmao) {
			return impressao += no.getInfo() + "; ";
		}

		if (hasFilho) {
			imprimePosOrdem(no.getFilho());
		}
		
		impressao += no.getInfo() + "; ";
		
		if (hasIrmao) {
			imprimePosOrdem(no.getIrmao());
		}
		
		return impressao;
	}
	
	public int getQuantidadeDeNosFolha(NoArvore<T> no, int index) {
		int indexFilho = index; 
		
		if (no.getFilho() != null) {
			getQuantidadeDeNosFolha(no.getFilho(), indexFilho+1);
	       
		}else {
	            if (no.getFilho() == null) {
	                this.setQtdFolhas();
	            }
	        }
		int indexIrmao = index;
	        if (no.getIrmao() != null) {
	        	getQuantidadeDeNosFolha(no.getIrmao(), indexIrmao);
	        }

	        return this.getQtdFolhas(); 
	    }
	
	public void setQtdFolhas() {
		this.qtdFolhas++;
	}
	
	public int getQtdFolhas() {
		return this.qtdFolhas;
	}
	
	@Override
	public String toString() {
		return this.info.toString();
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}
	
	public NoArvore<T> getFilho() {
		return filho;
	}

	public void setFilho(NoArvore<T> filho) {
		this.filho = filho;
	}

	public NoArvore<T> getIrmao() {
		return irmao;
	}

	public void setIrmao(NoArvore<T> irmao) {
		this.irmao = irmao;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getMenorAltura() {
		return menorAltura;
	}

	public void setMenorAltura(int inc) {
		this.menorAltura = inc;
	}
}