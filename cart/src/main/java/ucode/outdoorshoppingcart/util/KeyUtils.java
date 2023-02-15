package ucode.outdoorshoppingcart.util;

/**
 * IdUtils
 */
public class KeyUtils {

  public static String cid(Long cid) {
    return "cid:" + cid;
  }

  public static String pid(Long pid) {
    return "pid:" + pid;
  }

  public static String globalCid() {
    return "cid:global";
  }
}
