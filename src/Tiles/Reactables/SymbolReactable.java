package Tiles.Reactables;

public interface SymbolReactable {

    Reaction reactWithSword();

    Reaction reactWithShield();

    Reaction reactWithNothing();

    Reaction causes(Symbol symbol);

//    void reactWithFace(Face face);

}
