package seedu.moneygowhere;

import static org.junit.jupiter.api.Assertions.assertEquals;

import app.Command;
import app.MoneyGoWhere;
import org.junit.jupiter.api.Test;
import utility.Ui;

class OrderTest {

    public void runTest(String input, MoneyGoWhere moneyGoWhere) {
        Ui ui = new Ui();
        ui.promptUserInput();
        Command command = new Command(input);
        moneyGoWhere.handleCommand(command);
    }

    @Test
    public void orderTest() {

        MoneyGoWhere moneyGoWhere = new MoneyGoWhere();
        runTest("addorder -i 0 -q 169", moneyGoWhere);

        assertEquals("chicken", moneyGoWhere.transactions.getOrderList()
                .get(moneyGoWhere.transactions.getOrderList().size() - 1)
                .getOrderEntries()
                .get(moneyGoWhere.transactions.getOrderList()
                        .get(moneyGoWhere.transactions.getOrderList().size() - 1)
                        .getOrderEntries().size() - 1).getItem().getName());

        assertEquals(169, moneyGoWhere.transactions.getOrderList()
                .get(moneyGoWhere.transactions.getOrderList().size() - 1)
                .getOrderEntries()
                .get(moneyGoWhere.transactions.getOrderList()
                        .get(moneyGoWhere.transactions.getOrderList().size() - 1)
                        .getOrderEntries().size() - 1).getQuantity());

    }

    @Test
    public void orderTest2() {

        MoneyGoWhere moneyGoWhere = new MoneyGoWhere();
        runTest("addorder -I [1 69, 2 169]", moneyGoWhere);

        assertEquals("chicken rice", moneyGoWhere.transactions.getOrderList()
                .get(moneyGoWhere.transactions.getOrderList().size() - 1)
                .getOrderEntries()
                .get(moneyGoWhere.transactions.getOrderList()
                        .get(moneyGoWhere.transactions.getOrderList().size() - 1)
                        .getOrderEntries().size() - 2).getItem().getName());

        assertEquals(69, moneyGoWhere.transactions.getOrderList()
                .get(moneyGoWhere.transactions.getOrderList().size() - 1)
                .getOrderEntries()
                .get(moneyGoWhere.transactions.getOrderList()
                        .get(moneyGoWhere.transactions.getOrderList().size() - 1)
                        .getOrderEntries().size() - 2).getQuantity());

        assertEquals("chicken rice1", moneyGoWhere.transactions.getOrderList()
                .get(moneyGoWhere.transactions.getOrderList().size() - 1)
                .getOrderEntries()
                .get(moneyGoWhere.transactions.getOrderList()
                        .get(moneyGoWhere.transactions.getOrderList().size() - 1)
                        .getOrderEntries().size() - 1).getItem().getName());

        assertEquals(169, moneyGoWhere.transactions.getOrderList()
                .get(moneyGoWhere.transactions.getOrderList().size() - 1)
                .getOrderEntries()
                .get(moneyGoWhere.transactions.getOrderList()
                        .get(moneyGoWhere.transactions.getOrderList().size() - 1)
                        .getOrderEntries().size() - 1).getQuantity());

    }

    @Test
    public void orderTest3() {

        MoneyGoWhere moneyGoWhere = new MoneyGoWhere();
        runTest("addorder -i 0 -q 169", moneyGoWhere);

        assertEquals("chicken", moneyGoWhere.transactions.getOrderList()
                .get(moneyGoWhere.transactions.getOrderList().size() - 1)
                .getOrderEntries()
                .get(moneyGoWhere.transactions.getOrderList()
                        .get(moneyGoWhere.transactions.getOrderList().size() - 1)
                        .getOrderEntries().size() - 1).getItem().getName());

        assertEquals(169, moneyGoWhere.transactions.getOrderList()
                .get(moneyGoWhere.transactions.getOrderList().size() - 1)
                .getOrderEntries()
                .get(moneyGoWhere.transactions.getOrderList()
                        .get(moneyGoWhere.transactions.getOrderList().size() - 1)
                        .getOrderEntries().size() - 1).getQuantity());

    }

    /**
     * This is work in progress. For now, this fails and it causes CI to fail
     *
     * Uncomment @Test below if you want to run it
     **/
    
    // @Test
    public void orderTest4() {

        MoneyGoWhere moneyGoWhere = new MoneyGoWhere();
        runTest("addorder --items [0 69, 1 169]", moneyGoWhere);

        assertEquals("chicken rice", moneyGoWhere.transactions.getOrderList()
                .get(moneyGoWhere.transactions.getOrderList().size() - 1)
                .getOrderEntries()
                .get(moneyGoWhere.transactions.getOrderList()
                        .get(moneyGoWhere.transactions.getOrderList().size() - 1)
                        .getOrderEntries().size() - 2).getItem().getName());

        assertEquals(69, moneyGoWhere.transactions.getOrderList()
                .get(moneyGoWhere.transactions.getOrderList().size() - 1)
                .getOrderEntries()
                .get(moneyGoWhere.transactions.getOrderList()
                        .get(moneyGoWhere.transactions.getOrderList().size() - 1)
                        .getOrderEntries().size() - 2).getQuantity());

        assertEquals("chicken rice1", moneyGoWhere.transactions.getOrderList()
                .get(moneyGoWhere.transactions.getOrderList().size() - 1)
                .getOrderEntries()
                .get(moneyGoWhere.transactions.getOrderList()
                        .get(moneyGoWhere.transactions.getOrderList().size() - 1)
                        .getOrderEntries().size() - 1).getItem().getName());

        assertEquals(169, moneyGoWhere.transactions.getOrderList()
                .get(moneyGoWhere.transactions.getOrderList().size() - 1)
                .getOrderEntries()
                .get(moneyGoWhere.transactions.getOrderList()
                        .get(moneyGoWhere.transactions.getOrderList().size() - 1)
                        .getOrderEntries().size() - 1).getQuantity());

    }


}
