package sample;

interface IAccumulateur {

    void push ();
    void drop();
    void swap();
    void add();
    void sub();
    void mult();
    void div();
    void neg();
    void backspace();
    void accumuler(int chiffre);
    void reset();
}
