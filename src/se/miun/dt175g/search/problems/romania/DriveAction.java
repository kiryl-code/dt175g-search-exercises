package se.miun.dt175g.search.problems.romania;

/**
 * The action of driving from one City to the next.
 * These actions are part of the definition of the Touring Romania problem.
 *
 * @author Christoffer Fink
 */
public final class DriveAction {

  public final City from;
  public final City to;

  private DriveAction(City from, City to) {
    if (from == null) {
      throw new IllegalArgumentException("null 'from' is not allowed.");
    }
    if (to == null) {
      throw new IllegalArgumentException("null 'to' is not allowed.");
    }
    this.from = from;
    this.to = to;
  }

  public static DriveAction of(City from, City to) {
    return new DriveAction(from, to);
  }

  public City getFrom() {
    return from;
  }
  public City getTo() {
    return to;
  }

  @Override
  public String toString() {
    return String.format("%s -> %s", from, to);
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof DriveAction)) {
      return false;
    }
    DriveAction other = (DriveAction) o;
    return from.equals(other.from) && to.equals(other.to);
  }

  @Override
  public int hashCode() {
    return from.hashCode() ^ to.hashCode();
  }

}
