package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movies;

import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerTest {
  private MovieManager manager = new MovieManager();
  private Movies first = new Movies(1,"bloodshot");
  private Movies second = new Movies(2,"onward");
  private Movies third = new Movies(3,"hotel");
  private Movies fourth = new Movies(4,"gentleman");
  private Movies fifth = new Movies(5,"invisible");
  private Movies sixth = new Movies(6,"trolls");
  private Movies seventh = new Movies(7,"numberOne");
  private Movies eighth = new Movies(8,"interstellar");
  private Movies ninth = new Movies(9,"lalaland");
  private Movies tenth = new Movies(10,"forrestGump");
  private Movies eleventh = new Movies (11,"wolfOfWallStreet");
  private Movies zero = new Movies();

  @Test
  public void shouldShowLastTenButAddedEleven() {
    manager.add(first);     //1
    manager.add(second);    //2
    manager.add(third);     //3
    manager.add(fourth);    //4
    manager.add(fifth);     //5
    manager.add(sixth);     //6
    manager.add(seventh);   //7
    manager.add(eighth);    //8
    manager.add(ninth);     //9
    manager.add(tenth);     //10
    manager.add(eleventh);  //11
    //необходимо отобразить список фильмов по мере их добавления ( впереди последние добавленные)
    Movies[] actual = manager.getAll();
    Movies[] expected = new Movies[]{eleventh,tenth,ninth,eighth,seventh,sixth,fifth,fourth,third,second};
    assertArrayEquals(expected, actual);
  }
  @Test
  public void shouldShowLastFiveButAddedEleven(){
    manager = new MovieManager(5);
    manager.add(first);     //1
    manager.add(second);    //2
    manager.add(third);     //3
    manager.add(fourth);    //4
    manager.add(fifth);     //5
    manager.add(sixth);     //6
    manager.add(seventh);   //7
    manager.add(eighth);    //8
    manager.add(ninth);     //9
    manager.add(tenth);     //10
    manager.add(eleventh);  //11
    Movies[] actual = manager.getLimitedMovies();
    Movies[] expected = new Movies[] {eleventh,tenth,ninth,eighth,seventh};
    assertArrayEquals(expected,actual);
  }
  @Test
  public void shouldShowLastFiveButAddedTwo() {
    manager.add(first);     //1
    manager.add(second);    //2
    Movies[] actual = manager.getLimitedMovies();
    Movies[] expected = new Movies[]{second, first};
    assertArrayEquals(expected, actual);
  }
  @Test
  public void shouldShowSomethingIfAddedLessThanTen() {
    manager.add(first);     //1
    manager.add(second);    //2
    manager.add(third);     //3
    Movies[] actual = manager.getAll();
    Movies[] expected = new Movies[]{third, second, first};
    assertArrayEquals(expected, actual);
  }
  @Test
  public void shouldShowTenIfAddedTen(){
    manager.add(first);     //1
    manager.add(second);    //2
    manager.add(third);     //3
    manager.add(fourth);    //4
    manager.add(fifth);     //5
    manager.add(sixth);     //6
    manager.add(seventh);   //7
    manager.add(eighth);    //8
    manager.add(ninth);     //9
    manager.add(tenth);     //10
    Movies [] actual = manager.getAll();
    Movies [] expected = new Movies[] {tenth,ninth,eighth,seventh,sixth,fifth,fourth,third,second,first};
    assertArrayEquals(expected,actual);
  }
  @Test
  public void shouldShowZero(){
    manager.add(zero);
    Movies [] actual = manager.getAll();
    Movies [] expected = new Movies[] {zero};
    assertArrayEquals(expected,actual);
  }
}
