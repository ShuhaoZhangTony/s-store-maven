package frontend.edu.brown.designer;

import frontend.voltdb.catalog.CatalogType;

import frontend.edu.brown.graphs.AbstractVertex;
import frontend.edu.brown.graphs.IGraph;

public class DesignerVertex extends AbstractVertex {

    public DesignerVertex() {
        super();
    }

    public DesignerVertex(CatalogType catalog_item) {
        super(catalog_item);
    }

    /**
     * Copy constructor
     * 
     * @param graph
     * @param copy
     */
    public DesignerVertex(IGraph<DesignerVertex, DesignerEdge> graph, AbstractVertex copy) {
        super(graph, copy);
    }
}
