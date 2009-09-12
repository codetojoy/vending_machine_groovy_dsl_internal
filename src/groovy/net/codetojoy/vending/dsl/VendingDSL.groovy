
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
        println 'service'
        def moneyState = new MoneyState(coinList)        
        def inventory = new InventoryState(inventoryMap)
        def action = new ServiceAction(moneyState, inventory)        
        action.apply(machineState)
    }
    
    def verify(def expected) {
        println "verify"
        def action = new VerifyAction(expected)
        action.apply(machineState)
    }
    
    def getN() { new CoinAction(MoneyState.NICKEL).apply(machineState) }
    def getD() { new CoinAction(MoneyState.DIME).apply(machineState) }
    def getQ() { new CoinAction(MoneyState.QUARTER).apply(machineState) }
    def getR() { new CoinAction(MoneyState.DOLLAR).apply(machineState) }
    
    def getCoinreturn() { new CoinReturnAction().apply(machineState) }
    
    def get(def item) {
        def action = new GetAction(item)
        action.apply(machineState)
        println "get $item"
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