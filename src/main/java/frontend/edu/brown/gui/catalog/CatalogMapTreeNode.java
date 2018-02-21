package frontend.edu.brown.gui.catalog;

import javax.swing.tree.DefaultMutableTreeNode;

import frontend.voltdb.catalog.CatalogMap;
import frontend.voltdb.catalog.CatalogType;

public class CatalogMapTreeNode extends DefaultMutableTreeNode {
    private static final long serialVersionUID = 1L;

    private final Class<? extends CatalogType> catalogType;
    
    public CatalogMapTreeNode(Class<? extends CatalogType> catalogType,
                              String label, CatalogMap<? extends CatalogType> items) {
        this(catalogType, label, items.size());
    }
    
    public CatalogMapTreeNode(Class<? extends CatalogType> catalogType,
                              String label, int size) {
        super(label + " (" + size + ")");
        this.catalogType = catalogType;
    }
    
    public Class<? extends CatalogType> getCatalogType() {
        return (this.catalogType);
    }
}