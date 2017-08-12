package Tiles.Reactables;

public enum Reaction implements ReactionVisitorAcceptable {
    PUSHED {
        @Override
        public void accept(ReactionVisitor rv, Piece piece) {
            //todo pushed in which dir?
            rv.visitPushed(piece);
        }
    },

    KILLED {
        @Override
        public void accept(ReactionVisitor rv, Piece piece) {
            rv.visitKilled(piece);
        }
    },

    NONE {
        @Override
        public void accept(ReactionVisitor rv, Piece piece) {
            rv.visitNone(piece);
        }
    }
}
