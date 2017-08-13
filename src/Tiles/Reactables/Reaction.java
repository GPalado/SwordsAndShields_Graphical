package Tiles.Reactables;

public enum Reaction implements ReactionVisitorAcceptable {
    PUSHED_RIGHT {
        @Override
        public void accept(ReactionVisitor rv, Reactable reactable) {
            //todo pushed in which dir?
            rv.visitPushed(reactable);
        }
    },

    PUSHED_LEFT {
        @Override
        public void accept(ReactionVisitor rv, Reactable reactable) {
            //todo pushed in which dir?
            rv.visitPushed(reactable);
        }
    },

    PUSHED_UP {
        @Override
        public void accept(ReactionVisitor rv, Reactable reactable) {
            //todo pushed in which dir?
            rv.visitPushed(reactable);
        }
    },

    PUSHED_DOWN {
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
