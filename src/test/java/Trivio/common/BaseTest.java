package Trivio.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;


public class BaseTest {
    private Logger logger;
    public BaseTest(){
        logger = LogManager.getLogger(getClass());
    }
    protected boolean verifyTrue(boolean condition){
        boolean pass = true;
        try {
            Assert.assertTrue(condition);
        }catch (Exception e){
            e.printStackTrace();
            pass = false;
        }
        return pass;
    }

    protected boolean verifyFalse(boolean condition){
        boolean pass = true;
        try {
            Assert.assertFalse(condition);
        }catch (Exception e){
            e.printStackTrace();
            pass = false;
        }
        return pass;
    }

    protected boolean verifyEquals(Object expected, Object actual){
        boolean pass = true;
        try {
            Assert.assertEquals(expected, actual);
        }catch (Exception e){
            e.printStackTrace();
            pass = false;
        }
        return pass;
    }
//    protected boolean verifyTrue(boolean condition){
//        boolean pass = true;
//        try {
//            Assert.assertTrue(condition);
//            logger.info("--------- PASSED ---------");
//        }catch (Throwable e){
//            logger.info("--------- FAILED ---------");
//            pass = false;
//        }
//        return pass;
//    }
//
//    protected boolean verifyFalse(boolean condition) {
//        boolean pass = true;
//        try {
//            Assert.assertFalse(condition);
//            logger.info("--------- PASSED ---------");
//        } catch (Throwable e) {
//            logger.info("--------- FAILED ---------");
//            pass = false;
//        }
//        return pass;
//    }
//
//    protected boolean verifyEquals(Object actual, Object expected) {
//        boolean pass = true;
//        try {
//            Assert.assertEquals(actual, expected);
//            logger.info("--------- PASSED ---------");
//        } catch (Throwable e) {
//            logger.info("--------- FAILED ---------");
//            pass = false;
//        }
//        return pass;
//    }
}
