
// Project: Vending Machine in Groovy
// Author: Michael Easter
//
// http://codetojoy.blogspot.com

package net.codetojoy.vending.dsl

import net.codetojoy.vending.*
import net.codetojoy.vending.action.* 
 
// This class is the "context" for the DSL

class Machine {
    def machineState = new MachineState()
    
    def service(def coinList, def inventoryMap) {
        machineState.availableChange = new MoneyState(coinList)
        machineState.inventoryState = new InventoryState(inventoryMap)        
    }
    
    def verify(def expectedStr) {
        def expected = expectedStr.trim()
        def actual = machineState.toString()
        
        if (actual != expected) {
            println "EXPECTED = .${expected}."
            println "ACTUAL .${actual}."            
        }
        
        assert expected == actual
    }
    
    def getN() { machineState.addInsertedMoney(MoneyState.NICKEL) }
    def getD() { machineState.addInsertedMoney(MoneyState.DIME) }
    def getQ() { machineState.addInsertedMoney(MoneyState.QUARTER) }
    def getR() { machineState.addInsertedMoney(MoneyState.DOLLAR) }
    
    def getCoinreturn() { machineState.insertedMoney = MoneyState.ZERO }
    
    def get(def item) {
        machineState.getItem(item)
    }
    
    def accept(closure) {
        try {
            closure.delegate = this
            closure()
            println "done"
        } catch(Throwable t) {
            def msg1 = ">>>>>>> ERROR! type ${t.class} msg ${t.message}"
            println msg1
            def runLog = new File("error.log").newWriter()
            runLog << msg1
            runLog.close()
            System.exit(-1)
        }    
    }
}

def machine = new Machine()