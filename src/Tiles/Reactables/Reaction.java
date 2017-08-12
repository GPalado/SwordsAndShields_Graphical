package Tiles.Reactables;

public enum Reaction implements ReactionVisitorAcceptable {
    PUSHED {
        @Override
        public void accept(ReactionVisitor rv, Reactable reactable) {
            //todo pushed in which dir?
            rv.visitPushed(reactable);
        }
    },

    KILLED {
        @Override
        public void accept(ReactionVisitor rv, Reactable reactable) {
            rv.visitKilled(reactable);
        }
    },

    NONE {
        @Override
        public void accept(ReactionVisitor rv, Reactable reactable) {
            rv.visitNone(reactable);
        }
    }
}
