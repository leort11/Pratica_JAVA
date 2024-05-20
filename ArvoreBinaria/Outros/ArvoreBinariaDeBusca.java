package Outros;
public class ArvoreBinariaDeBusca <X extends Comparable<X>> implements Cloneable
{
    private class No
    {
        private No esq;
        private X  info;
        private No dir;

        public No (No esq, X info, No dir)
        {
            this.esq =esq;
            this.info=info;
            this.dir =dir;
        }

        public No (X info)
        {
            this(null,info,null);
        }

        public No (No esq, X info)
        {
            this(esq,info,null);
        }

        public No (X info, No dir)
        {
            this(null,info,dir);
        }

        public No getEsq ()
        {
            return this.esq;
        }

        public X getInfo ()
        {
            return this.info;
        }

        public No getDir ()
        {
            return this.dir;
        }

        public void setEsq (No esq)
        {
            this.esq=esq;
        }

        public void setInfo (X info)
        {
            this.info=info;
        }

        public void setDir (No dir)
        {
            this.dir=dir;
        }
        
        // métodos obrigatórios
    }

    private No raiz;

    private X meuCloneDeX (X x)
    {
        X ret=null;

        try
        {
            Class<?> classe         = x.getClass();
            Class<?>[] tipoDosParms = null;
            Method metodo           = classe.getMethod("clone",tipoDosParms);
            Object[] parms          = null;
            ret                     = (X)metodo.invoke(x,parms);
        }
        catch(NoSuchMethodException erro)
        {}
        catch(IllegalAccessException erro)
        {}
        catch(InvocationTargetException erro)
        {}

        return ret;
    }
    
    public void inclua (X inf) throws Exception
    {
        if (inf==null) throw new Exception ("informacao ausente");

        No info;
        if (inf instanceof Cloneable)
            info = (X)meuCloneDeX(inf);
        else
            info = inf;

        if (this.raiz==null)
        {
            this.raiz = new No (info);
            return;
        }

        No atual = this.raiz;

        for(;;) // forever
        {
            int comparacao = info.compareTo(atual.getInfo());
            if (comparacao==0) throw new Exception ("informacao repetida");

            if (comparacao<0) // deve-se inserir info para o lado esquerdo
               if (atual.getEsq()!=null) 
                   atual=atual.getEsq();
               else // achei onde inserir; eh para a esquerda do atual
               {
                   atual.setEsq (new No (info));
                   return;
               }
            else // deve-se inserir info para o lado direito
               if (atual.getDir()!=null) 
                   atual=atual.getDir();
               else // achei onde inserir; eh para a direito do atual
               {
                   atual.setDir (new No (info));
                   return;
               }
        }
    }

	public boolean tem (X info) throws Exception
	{
		if (info==null) throw new Exception ("informacao ausente");

        No atual=this.raiz;
        for(;;) // forever
        {
			if (atual==null) return false;
			
            int comparacao = info.compareTo(atual.getInfo());
            if (comparacao==0) return true;
            
            if (comparacao<0)
                atual=atual.getEsq();
            else // comparacao>0
                atual=atual.getDir();
        }
	}

    public X getMenor () throws Exception
    {
	    if (this.raiz==null) throw new Exception ("arvore vazia");
	    
        No atual=this.raiz, ret=null;
        for(;;) // forever
        {
			if (atual.getEsq()==null)
			{
				if (atual.getInfo() instandeof Cloneable)
     				ret = (X)meuCloneDeX(atual.getInfo());
     			else
     			    ret = atual.getInfo();
     			
     			break;
			}
            else
                atual=atual.getEsq();
		}
		
		return ret;
    }

    public X getMaior () throws Exception
    {
	    if (this.raiz==null) throw new Exception ("arvore vazia");
	    
        No atual=this.raiz, ret=null;
        for(;;) // forever
        {
			if (atual.getDir()==null)
			{
				if (atual.getInfo() instandeof Cloneable)
     				ret = (X)meuCloneDeX(atual.getInfo());
     			else
     			    ret = atual.getInfo();
     			
     			break;
			}
            else
                atual=atual.getDir();
		}
		
		return ret;
    }
    
    public void remova (X info) throws Exception
    {
	    if (info==null) throw new Exception ("informacao ausente");
	    
	    // continue a implementação
	    // ok, mas como?
	    
	    // se a info não for encontrada na arvore, dê uma exceção
	    
	    // se a info for encontrada numa folha, deslique a folha da árvore,
	    // fazendo o ponteiro que aponta para ela dentro do seu nó pai,
	    // tornar-se null
	    
	    // se info for encontrada num nó N, que não é folha, sendo que N
	    // só tem filho à esquerda, e sendo N filho esquerdo de um certo
	    // pai P, faça o ponteiro esquerdo de P, passar a apontar para
	    // esse filho que ha na esquerda de N

	    // se info for encontrada num nó N, que não é folha, sendo que N
	    // só tem filho à esquerda, e sendo N filho direito de um certo
	    // pai P, faça o ponteiro direito de P, passar a apontar para
	    // esse filho que ha na esquerda de N

	    // se info for encontrada num nó N, que não é folha, sendo que N
	    // só tem filho à direita, e sendo N filho esquerdo de um certo
	    // pai P, faça o ponteiro esquerdo de P, passar a apontar para
	    // esse filho que ha na direita de N

	    // se info for encontrada num nó N, que não é folha, sendo que N
	    // só tem filho à direita, e sendo N filho direita de um certo
	    // pai P, faça o ponteiro direito de P, passar a apontar para
	    // esse filho que ha na direita de N

	    // se info for encontrada num nó N, que não é folha e tem 2 filhos,
	    // encontre a informação info que existe à extrema esquerda da
	    // subarvore direita de N ou à extrema direita da subarvore esquerda
	    // de N; remova o nó que contém info e substitua dentro do nó N,
	    // a informação que ali se encontra por info
    }
}



















