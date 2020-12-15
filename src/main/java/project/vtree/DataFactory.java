package project.vtree;

import java.util.ArrayList;
import java.util.List;

public class DataFactory {

    private static DataFactory dataFactory = null;

    public List<ProductVTree> productVTrees = new ArrayList<>();
    public List<ProductVTree> treeBeanList = new ArrayList<>();
    public List<CommodityVTree> commodityVTreeList = new ArrayList<>();

    public static DataFactory getInstance() {
        if (dataFactory == null) {
            dataFactory = new DataFactory();
        }

        return dataFactory;
    }

    public void addProductVTree(ProductVTree baseBean) {
        productVTrees.add(baseBean);
    }

    public void addTreeBean(ProductVTree productVTree) {
        treeBeanList.add(productVTree);
    }

    public void addCommodityBean(CommodityVTree commodityVTree) {
        commodityVTreeList.add(commodityVTree);
    }

    public ProductVTree getBaseBeanById(String id) {
        if (null == id || id.isEmpty()) return null;
        try {
            return productVTrees.stream().filter(baseBean -> baseBean.id.equals(id)).findFirst().get();
        } catch (Exception e) {
            System.out.println("find id = " + id + ",, e = " + e.getMessage());
        }

        return null;

    }

    public ProductVTree getVTreeBeanById(String id) {
        return treeBeanList.stream().filter(baseBean -> baseBean.id.equals(id)).findFirst().get();
    }

    public CommodityVTree getCommodityBeanById(String id) {
        return commodityVTreeList.stream().filter(baseBean -> baseBean.id.equals(id)).findFirst().get();
    }

    public void updateBaseBean(ProductVTree baseBean) {
        int index = productVTrees.indexOf(productVTrees.stream().filter(bean -> bean.id.equals(baseBean.id)).findFirst().get());

        productVTrees.set(index, baseBean);

    }
}
