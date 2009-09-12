
// Project: Vending Machine in Groovy
// Author: Michael Easter
//
// http://codetojoy.blogspot.com

package net.codetojoy.vending

class InventoryStateTestCase extends GroovyTestCase {
    
    def inventoryState = null
    
    public void setUp() {
        def items = []
        items << [n:'A', p:'100', c:'10'] 
        items << [n:'B', p:'400', c:'1'] 
        items << [n:'C', p:'100', c:'0']
        inventoryState = new InventoryState(items) 
    }

    public void testGetCount() {
        assert 10 == inventoryState.getCount('A')
    }
    
    public void testGetItem() {
        // pre
        assert ItemRequestState.IN_STOCK == inventoryState.isItemAvailable('B')
        // test
        inventoryState.getItem('B')
        // post
        assert ItemRequestState.OUT_OF_STOCK == inventoryState.isItemAvailable('B')
    }
    
    public void testGetPrice() {
        def price = inventoryState.getPrice('A')
        def expectedState = new MoneyState(100)
        assert expectedState == price 
    }
    
    public void testFindItemByName_Yes() {
        def result = inventoryState.findItemByName('A')
        assert null != result
    }
    
    public void testFindItemByName_No() {
        def result = inventoryState.findItemByName('M')
        assert null == result
    }
    
    public void testIsItemAvailable_InStock() {
        def result = inventoryState.isItemAvailable('A')
        assert ItemRequestState.IN_STOCK == result
    }
    
    public void testIsItemAvailable_OutOfStock() {
        assert ItemRequestState.OUT_OF_STOCK == inventoryState.isItemAvailable('C')
    }
    
    public void testIsItemAvailable_Unknown() {
        assert ItemRequestState.UNKNOWN == inventoryState.isItemAvailable('X')
    }    
}
