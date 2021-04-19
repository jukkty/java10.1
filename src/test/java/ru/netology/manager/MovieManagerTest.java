package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movies;

import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerTest {
  private MovieManager manager = new MovieManager();
  private Movies bloodshot = new Movies(1,"bloodshot");
  private Movies onward = new Movies(2,"onward");
  private Movies belgrad = new Movies(3,"belgrad");
  private Movies gentleman = new Movies(4,"gentleman");
  private Movies invisible = new Movies(5,"invisible");
  private Movies trolls = new Movies(6,"trolls");
  private Movies numberOne = new Movies(7,"numberOne");

  @BeforeEach
  public void setUp() {
    manager.add(bloodshot); //1
    manager.add(onward);    //2
    manager.add(belgrad);   //3
    manager.add(gentleman); //4
    manager.add(invisible); //5
    manager.add(trolls);    //6
    manager.add(numberOne); //7
  }
  @Test
  public void shouldShowIndexFromLastToFirst() {
    //необходимо отобразить список фильмов по мере их добавления ( впереди последние добавленные)
    manager.getAll();
    Movies[] actual = manager.getAll();
    Movies[] expected = new Movies[]{numberOne,trolls,invisible,gentleman,belgrad,onward,bloodshot};
    assertArrayEquals(expected, actual);
  }
  @Test
  public void shouldShowLastFive(){
    manager.getLastFive();
    Movies[] actual = manager.getLastFive();
    Movies[] expected = new Movies[] {numberOne,trolls,invisible,gentleman,belgrad};
    assertArrayEquals(expected,actual);
  }
}
