public abstract class Semaphore {

    protected int valeur=0;

    protected Semaphore (int valeurInitiale){
        valeur = valeurInitiale;
    }

    public synchronized void syncWait() {
        try{
            while(valeur<=0) {
                wait();
            }
            valeur --;}
        catch(InterruptedException e) {}}
    public synchronized void syncSignal( )
    {
        if(++valeur > 0 ) notifyAll() ;
    }
}