//Explicar cómo se podría implementar una DoubleStackQueue<E> que implemente la interfaz Queue<E>
    //utilizando únicamente dos Stacks.

public class DoubleStackQueue<E> implements Queue<E>{
    private Stack<E> instack;   //para todo lo que ingrese a la queue
    private Stack<E> outstack; //para todo lo que salga de la queue

    public enqueue(E item){
        instack.push(item);
    }

    public dequeue(){
        if(outstack.isEmpty()){
            while(!instack.isEmpty()){      //voy dando vuelta lo que tengo en la entrada, y vacio instack
                outstack.push(instack.pop());
            }
            if(outstack.isEmpty()){         // si despues del while el outstack sigue vacio, es que ambos estaban vacios desde un inicio
                throw new EmptyStackException();
            }
        }
        return outstack.pop();
    }
}

//Explicar el concepto de amortización en una implementación resizable de un ArrayStack y cómo impacta
    //en el orden del push() y pop().