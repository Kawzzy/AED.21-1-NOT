package arvores;

public class TesteDaArvoreNAria {
	public static void main(String args[]) {
		NoArvore<Integer> n10 = new NoArvore<Integer>(10);
		NoArvore<Integer> n9 = new NoArvore<Integer>(9);
		n9.inserirFilho(n10);
		NoArvore<Integer> n4 = new NoArvore<Integer>(4);

		NoArvore<Integer> n8 = new NoArvore<Integer>(8);
		NoArvore<Integer> n3 = new NoArvore<Integer>(3);
		n3.inserirFilho(n4);

		NoArvore<Integer> n5 = new NoArvore<Integer>(5);
		NoArvore<Integer> n6 = new NoArvore<Integer>(6);
		NoArvore<Integer> n7 = new NoArvore<Integer>(7);
		n7.inserirFilho(n9);
		n7.inserirFilho(n8);
		


		NoArvore<Integer> n2 = new NoArvore<Integer>(2);
		n2.inserirFilho(n5);
		n2.inserirFilho(n3);
		

		NoArvore<Integer> n1 = new NoArvore<Integer>(1);
		n1.inserirFilho(n7);
		n1.inserirFilho(n6);
		n1.inserirFilho(n2);
		

		Arvore<Integer> a = new Arvore<>();
		a.setRaiz(n1);
		System.out.println(a.toString());
		System.out.println(a.getQuantidadeDeNosFolha());
		System.out.println(a.imprimePosOrdem());
	}
}