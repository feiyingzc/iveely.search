/**
 * date   : 2016年1月29日 author : Iveely Liu contact: sea11510@mail.ustc.edu.cn
 */
package com.iveely.brain.daiml;

import org.dom4j.Element;

import java.util.List;

import com.iveely.brain.mind.React;

/**
 * @author {Iveely Liu}
 */
public abstract class ITemplate {

  /**
   * Parse the element of template.
   *
   * @param element The element of template.
   * @return true is successfully parse,or is not.
   */
  public abstract boolean parse(Element element);

  /**
   * Get status of the template.
   *
   * @return the status of template.
   */
  public abstract React.Status getStatus();

  /**
   * Get result by template.
   * @param that last question
   * @param stars starts
   * @return the result.
   */
  public abstract String getResult(List<String> stars, String that);

  /**
   * @param text text
   * @param ids ids
   * @param stars stars
   * Replace star.
   */
  public String replaceStar(String text, List<Integer> ids, List<String> stars) {
    String ret = text;
    if (ids != null && ids.size() > 0) {
      for (Integer id : ids) {
        ret = ret.replace("%s" + id + "%", stars.get(id - 1));
      }
    }
    return ret;
  }

  /**
   * All types of the template.
   *
   * @author {Iveely Liu}
   */
  public enum Type {
    NORMAL, RANDOM, SRAI, REQUEST, UNKNOW
  }

}
