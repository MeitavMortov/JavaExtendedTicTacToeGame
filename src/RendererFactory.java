/**
 * File for the TicTacToe exercise.
 * Represents a code which creates RendererFactory.
 * The RendererFactory can :
 * build a renderer of a specific given type.
 * @author Meitav Mortov Ovadya
 */


class RendererFactory{

    /**
     * This method builds a renderer of a specific given type.
     * @param  rendererType a string represents the player Type  to build.
     * @return renderer of a specific given type, if type was valid return null renderer.
     */
    public Renderer buildRenderer(String rendererType){
        Renderer renderer;
        switch(rendererType) {
            case "console":
                renderer = new ConsoleRenderer();
                break;
            case "none":
                renderer = new VoidRenderer();
                break;
            default:
                renderer = null;
                break;
        }
        return renderer;
    }

}

