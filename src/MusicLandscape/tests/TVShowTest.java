// **************************************************
//		
//       git.rev = 234
//  git.revision = fdd4980be270473bdd7e8206afeda65ab6e4c3a4
//         stage = ES03
//
// ***************************************************
package MusicLandscape.tests;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNotSame;
import static org.testng.Assert.fail;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import MusicLandscape.entities.Artist;
import MusicLandscape.entities.Event;
import MusicLandscape.entities.TVShow;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import MusicLandscape.Date;
import MusicLandscape.Venue;


/**
 * 
 * @author TeM
 * @version 234
 * @Stage ES03
 *
 */
public class TVShowTest {
	TVShow toTest;
	
	@BeforeMethod
	private void init(){
		this.toTest =new TVShow();
	}
	

	
	/**
	   * tries to get a private field of the given object
	   * @param myObject Object of which the field should be reached
	   * @param fieldName String which defines the field to be retrieved
	   * @return new Field object if found, fails if NoSuchFieldException
	   */
		private <T> Field getPrivateField(final T myObject, final String fieldName, final boolean isBase){
			final Field privateStringField;
			try {
				privateStringField = (isBase)?myObject.getClass().getDeclaredField(fieldName):myObject.getClass().getSuperclass().getDeclaredField(fieldName);
				privateStringField.setAccessible(true);
				return privateStringField;
			} catch (final NoSuchFieldException e) {
				// TODO Auto-generated catch block
				fail("member \""+fieldName+"\" not found");
			} catch (final SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		
	
		/**
		 * checks all initial values 
		 * 	-> 0 for numbers, 
		 * 	null for String, 
		 * 	any non-null value for reference members
		 */
  @Test
  public void TVShow() {
		String message="";
		final List<Object[]> myList= new ArrayList<Object[]>();
		
		myList.add(new Object[]{"s", "name",null});
		myList.add(new Object[]{"i", "viewers",0});
		
		
		for (final Object[] li : myList){
			message=String.format("initial value for %s should be %s\n",li[1], li[2]);
			try {
				switch (li[0].toString()) {
				case "i":case "s":
					assertEquals(this.getPrivateField(this.toTest, li[1].toString(), true).get(this.toTest),li[2],message);
					break;
				case "nn":
					assertNotNull(this.getPrivateField(this.toTest, li[1].toString(), true).get(this.toTest),message);
					break;
				}
				
			} catch (final IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (final IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}				
		}
		
		assertEquals((this.toTest instanceof Event), true, "Class not inherited as expected\n");
  }

  @Test
  public void TVShowTVShow() {
	 final TVShow toCopy= new TVShow();

		toCopy.setAttendees(20);
		toCopy.setDescription("my description");
		toCopy.setName("The Tonight Show");
		toCopy.setViewers(600);
		
		final TVShow toCheck=new TVShow(toCopy);
		

		//not the same object
		assertNotSame(toCheck,toCopy);
		//desc and attendees correct values
		assertEquals(toCheck.getDescription(), toCopy.getDescription(), "description has to be a copy\n");
		assertEquals(toCheck.getAttendees(), toCopy.getAttendees(), "Attendees has to be a copy\n");
		assertNotSame(toCheck.getArtist(), toCopy.getArtist(), "Artist has to be a deep copy of the given argument\n");
		assertNotSame(toCheck.getVenue(), toCopy.getVenue(), "Venue has to be a deep copy of the given argument\n");
		assertNotSame(toCheck.getDate(), toCopy.getDate(), "Date has to be a deep copy of the given argument\n");
		
		assertEquals(toCheck.getName(), toCopy.getName());
		assertEquals(toCheck.getViewers(), toCopy.getViewers());
	 
  }

  @Test
  public void TVShowEvent() {
	  	final Event toCopy=new Event();
		toCopy.setAttendees(20);
		toCopy.setDescription("my description");
		
		final TVShow toCheck=new TVShow(toCopy);
		

		//not the same object
		assertNotSame(toCheck,toCopy);
		//desc and attendees correct values
		assertEquals(toCheck.getDescription(), toCopy.getDescription(), "description has to be a copy\n");
		assertEquals(toCheck.getAttendees(), toCopy.getAttendees(), "Attendees has to be a copy\n");
		assertNotSame(toCheck.getArtist(), toCopy.getArtist(), "Artist has to be a deep copy of the given argument\n");
		assertNotSame(toCheck.getVenue(), toCopy.getVenue(), "Venue has to be a deep copy of the given argument\n");
		assertNotSame(toCheck.getDate(), toCopy.getDate(), "Date has to be a deep copy of the given argument\n");
		
		assertEquals(toCheck.getName(), null);
		assertEquals(toCheck.getViewers(), 0);
  }

  @Test(dataProvider="name")
  public void getName(final String in, final String out) {
	//reflect private field name
	  final Field f= this.getPrivateField(this.toTest, "name",true);
	  try {
		f.set(this.toTest, in);
		} catch (final IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (final IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  assertEquals(this.toTest.getName(),out);
  }

  @Test(dataProvider="name")
  public void setName(final String in, final String out) {
	  final Field f= this.getPrivateField(this.toTest, "name",true);
	  this.toTest.setName(in);
	  try {
	    assertEquals(f.get(this.toTest),in);
	  } catch (final Exception e) {}
  }
  @DataProvider(name = "name")
  private static Object[][] name() {
      return new Object[][] { { null, null}, {"Johnny Cash", "Johnny Cash"}};
  }
  @Test(dataProvider="viewers")
  public void getViewers(final int in, final int out) {
	//reflect private field name
	  final Field f= this.getPrivateField(this.toTest, "viewers",true);
	  try {
		f.set(this.toTest, in);
		} catch (final IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (final IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  assertEquals(this.toTest.getViewers(),in,"value should be "+in);
  }
  @Test(dataProvider="viewers")
  public void setViewers(final int in, final int out) {
	  final Field f= this.getPrivateField(this.toTest, "viewers",true);
	  this.toTest.setViewers(in);
	  try {
	    assertEquals(f.get(this.toTest),out, "value should be "+out);
	  } catch (final Exception e) {}
  }
  
  @DataProvider(name = "viewers")
  private static Object[][] viewers() {
      return new Object[][] { { 0, 0}, {-1, 0},{200, 200} };
  }

  @Test(dataProvider="impact")
  public void impact(final int viewers, final int attendees, final int impact) {
	//reflect private field name
	  Field f= this.getPrivateField(this.toTest, "viewers", true);
	  try {
		f.set(this.toTest, viewers);
		} catch (final IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (final IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//reflect private field attendees from super class
	  	
	  f= this.getPrivateField(this.toTest, "attendees", false);
	  try {
		f.set(this.toTest, attendees);
		} catch (final IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (final IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals(this.toTest.impact(), impact);
	  
  }
  @DataProvider(name = "impact")
  private static Object[][] impacts() {
      return new Object[][] { { 0,0, 0}, {0, 10, 20},{100,0, 200}, {10,10, 40} };
  }

  @Test
  public void testtoString() {
	  final String out="unknown @ unknown on null\n\n(0 attending (0))";
		assertEquals(new Event().toString(), out);
  }
  @Test
  public void testtoString2() {
	  	final TVShow toTest=new TVShow();
		
		final Venue myV=mock(Venue.class);
		when(myV.getName()).thenReturn("my Venue");
		
		toTest.setVenue(myV);
		toTest.setDescription("my fancy description");
		toTest.setAttendees(50);
		toTest.setViewers(20);
		
		toTest.setName("Late night show");
		
		//kein mock weil von uns implementiert und nicht sichergestellt, welche methode von dort aufgerufen wird
		final Date myDate=new Date();
		myDate.setJulian(2457091);
		toTest.setDate(myDate);
		
		final Artist a= mock(Artist.class);
		when(a.toString()).thenReturn("cool artist");
		when(a.getName()).thenReturn("cool artist");
		
		toTest.setArtist(a);
		final String out="cool artist @ Late night show on 09.03.2015\nmy fancy description\n(70 attending (140))";
		assertEquals(toTest.toString(), out);
  }
  
  @DataProvider(name = "toString")
  private static Object[][] string() {
	  //artistname, show name, date, description, viwer, attendees, impact
      return new Object[][] { { null,null, null, null, 0, 0, 0, "unknown @ unkown on null\n\n(0 attending (0))"},
    		  {0, 10, 20},
    		  {100,0, 200}, 
    		  {10,10, 40} };
  }
  
}
