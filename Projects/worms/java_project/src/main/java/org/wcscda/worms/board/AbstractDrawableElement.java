package org.wcscda.worms.board;

import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import java.util.*;
import org.wcscda.worms.Config;

// NRO 2021-09-27 : Drawable elements are present visually
//  but might not have physical presence (ie timer)
public abstract class AbstractDrawableElement implements Comparable<AbstractDrawableElement> {
  private static final TreeSet<AbstractDrawableElement> allDrawable = new TreeSet<>();
  private static final TreeSet<AbstractDrawableElement> toBeRemoved = new TreeSet<>();
  private static final TreeSet<AbstractDrawableElement> toBeAdded = new TreeSet<>();

  public static Set<AbstractDrawableElement> getAllDrawable() {
    return allDrawable;
  }

  public static void processToBeRemovedAndAdded() {
    allDrawable.removeAll(toBeRemoved);
    allDrawable.addAll(toBeAdded);
    toBeRemoved.clear();
    toBeAdded.clear();
  }

  private static int nextId;
  private Integer id;

  protected AbstractDrawableElement() {
    this.id = nextId++;
    allDrawable.add(this);
  }

  protected AbstractDrawableElement(boolean differedAdding) {
    this.id = nextId++;
    toBeAdded.add(this);
  }

  public final void draw(Graphics2D g, ImageObserver io) {
    drawMain(g, io);
    if (Config.isDebug()) {
      drawDebug(g, io);
    }
  }

  // By default, no debug print
  protected void drawDebug(Graphics2D g, ImageObserver io) {}

  protected abstract void drawMain(Graphics2D g, ImageObserver io);

  public void removeSelf() {
    toBeRemoved.add(this);
  }

  protected Integer getDepth() {
    return 0;
  }

  @Override
  public int compareTo(AbstractDrawableElement o) {
    return 1000000 * getDepth().compareTo(o.getDepth()) + id.compareTo(o.id);
  }
}
