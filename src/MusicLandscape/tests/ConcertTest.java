// **************************************************
//		
//       git.rev = 234
//  git.revision = fdd4980be270473bdd7e8206afeda65ab6e4c3a4
//         stage = ES03
//
// ***************************************************
package MusicLandscape.tests;
import MusicLandscape.entities.Artist;
import MusicLandscape.entities.Concert;
import MusicLandscape.entities.Event;
import MusicLandscape.entities.Track;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import MusicLandscape.Date;
import MusicLandscape.Venue;

import java.lang.reflect.Field;
import java.util.ArrayList;
import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

/**
 * 
 * @author TeM
 * @version 234
 * @Stage ES03
 *
 */
public class ConcertTest {
	Concert toTest;

	Track[]baseList;
	

	@BeforeMethod
	private void init() {
		this.toTest = new Concert();
		this.baseList = this.baseTestList();
	}

	private Track[] baseTestList(){
		final Track[] basList=new Track[10];
		for (int i=0; i<basList.length; i++){
			basList[i]= new Track();
			basList[i].setDuration(i*100);
				
		}
		return basList;
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
		  private boolean equals(final Track a, final Track b) {
			  boolean isEqual=false;
			    //check for self-comparison
			   // if ( a == b ) return true;
			    
			    //check each field
				isEqual=(a.getTitle().equals(b.getTitle())) &&
						(a.getDuration()==b.getDuration()) &&
					    (!a.getWriter().equals(b.getWriter())) && //writer is a deep copy
					    (!a.getPerformer().equals(b.getPerformer())) && //performer is a deep copy
					    (a.getYear()==b.getYear()) ;
			    return isEqual;
		  }
			 private void setbaseList(){
				 try {
					  Field f = this.getPrivateField(this.toTest, "setList",true);
					  f.set(this.toTest, this.baseList);
					  f = this.getPrivateField(this.toTest, "nextIdx",true);
					  f.set(this.toTest, this.baseList.length);
					} catch (final IllegalArgumentException | IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			 }
				
  @Test
  public void addTrack() {
	  final Track myT=new Track();
	  assertEquals(this.toTest.addTrack(myT), true, "track should be added and method return true");
	  this.toTest.addTrack(new Track());
	  //check length is 2 (two tracks in list)
		assertEquals(this.toTest.getSetList().length, 2, "two tracks should have been added");

	  assertEquals(this.toTest.addTrack(null),false , "null should not be added and method return false");

	  //check length is 2 (two tracks in list, null not added)
		assertEquals(this.toTest.getSetList().length, 2, "two tracks should have been added");
	  

	  
	  //check length is 2 (two tracks in list)
		assertEquals(this.toTest.getSetList().length, 2, "two tracks should have been added");
		
		//check Track is not copied - string is the same, hashcode too
		Track[] setl=new Track[1];
		try {
			setl = (Track[]) this.getPrivateField(this.toTest, "setList", true).get(this.toTest);
		} catch (final IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (final IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//check copy by reference
		assertEquals(setl[0], myT, "a Track should be added directly, not as copy!");



  }

  @Test
  public void duration() {
	  assertEquals(this.toTest.duration(), 0, "initial duration should be 0");
	  this.setbaseList();
	  
	  assertEquals(this.toTest.duration(), 4500, "duration for baselist should be 4500. Baselist contains 10 tracks with duration=idx*100");
  }

//  @Test
//  public void ensureCapacity() {
//    throw new RuntimeException("Test not implemented");
//  }

  @Test
  public void getSetList() {
    //add baselist hardcoded
	  this.setbaseList();
   
    //check return is a new list
	try {
		final Track[] origsetl = (Track[]) this.getPrivateField(this.toTest, "setList", true).get(this.toTest);
		final Track[] gotset= this.toTest.getSetList();
		assertNotSame(gotset, origsetl);
		
		for(int i=0;i<origsetl.length;i++){
			//check reference is not the same
			assertNotSame(gotset[i], origsetl[i]);
			//check the if the values are the same
			assertTrue(this.equals(gotset[i], origsetl[i]));
		}
	} catch (final IllegalArgumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (final IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
  }

  @Test
  public void impact() {
    assertEquals(this.toTest.impact(), 0, "with initial values , there is no impact (0)");
	  this.setbaseList();
	  this.toTest.setAttendees(10);
    assertEquals(this.toTest.impact(), 30, "with baselist and 10 attendees, impact should be 30 -> duration is 4500, attendees 30. check calculation" );
  }

  @Test
  public void nrTracks() {
    assertEquals(this.toTest.nrTracks(), 0);
	  this.setbaseList();
    assertEquals(this.toTest.nrTracks(), 10);
  }

  @Test
  public void resetSetList() {
	  this.toTest.resetSetList();
	  
	  try {
		 final Field f= this.getPrivateField(this.toTest, "setList", true);
		final Track[] toTestset= (Track[])f.get(this.toTest);
		for (final Track t:toTestset){
			assertEquals(t, null, "value should be resetted to null");
		}
		assertEquals(this.getPrivateField(this.toTest, "nextIdx", true).get(this.toTest), 0);
	} catch (final IllegalArgumentException | IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  this.setbaseList();
	  this.toTest.resetSetList();
	  try {
		 final Field f= this.getPrivateField(this.toTest, "setList", true);
		final Track[] toTestset= (Track[])f.get(this.toTest);
		for (final Track t:toTestset){
			assertEquals(t, null, "values should be resetted to null");
		}
		assertEquals(this.getPrivateField(this.toTest, "nextIdx", true).get(this.toTest), 0);
	} catch (final IllegalArgumentException | IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }

  @Test
  public void setSetListBasics() {

	  this.toTest.setSetList(this.baseList);

    	//reflect private field name
 		final Field f = this.getPrivateField(this.toTest, "setList",true);
 		try {
 			final Track[] toTestset= (Track[])f.get(this.toTest);
 			//check that not same reference
				assertNotSame(toTestset, this.baseList, "the lists should not be the same");
				
				
				//check same order of baseList and checkList
					//remove null values from baselist
					final ArrayList<Track> nnBase= new ArrayList<Track>();
					for(final Track t : this.baseList){
						if(t!=null){
							nnBase.add(t);
						}
					}
					
					Track[] baseClean=new Track[nnBase.size()];
					baseClean= nnBase.toArray(baseClean);
							
				for(int i=0;i<baseClean.length;i++){
					//check reference is not the same
					assertNotSame(toTestset[i], baseClean[i]);
					//check the if the values are the same
					assertTrue(this.equals(toTestset[i], baseClean[i]));
				}
				
					
				
		} catch (final IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (final IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
  }
  @Test
  public void setSetListWithNull() {
	  this.baseList[3]=null;
	  this.baseList[4]=null;
	  this.toTest.setSetList(this.baseList);

    	//reflect private field name
 		final Field f = this.getPrivateField(this.toTest, "setList",true);
 		try {
 			final Track[] toTestset= (Track[])f.get(this.toTest);
 			//check that not same reference
				assertNotSame(toTestset, this.baseList, "the lists should not be the same");



				
				//check same order of baseList and checkList
					//remove null values from baselist
					final ArrayList<Track> nnBase= new ArrayList<Track>();
					for(final Track t : this.baseList){
						if(t!=null){
							nnBase.add(t);
						}
					}
					
					Track[] baseClean=new Track[nnBase.size()];
					baseClean= nnBase.toArray(baseClean);
							
				for(int i=0;i<baseClean.length;i++){
					//check reference is not the same
					assertNotSame(toTestset[i], baseClean[i]);
					//check the if the values are the same
					assertTrue(this.equals(toTestset[i], baseClean[i]));
				}
				
					
				
		} catch (final IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (final IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
  }  


  @Test
  public void testtoString() {
	  final String out="unknown @ unknown on null\n\n(0 attending (0))";
		assertEquals(new Event().toString(), out);
  }
  @Test
  public void testtoString2() {
	  			
		final Venue myV=mock(Venue.class);
		when(myV.getName()).thenReturn("my Venue");

	  this.toTest.setVenue(myV);
	  this.toTest.setDescription("my fancy description");
	  this.toTest.setAttendees(50);

	  this.setbaseList();
		
		//kein mock weil von uns implementiert und nicht sichergestellt, welche methode von dort aufgerufen wird
		final Date myDate=new Date();
		myDate.setJulian(2457091);
	  this.toTest.setDate(myDate);
		
		final Artist a= mock(Artist.class);
		when(a.toString()).thenReturn("cool artist");
		when(a.getName()).thenReturn("cool artist");

	  this.toTest.setArtist(a);
		final String out="cool artist @ my Venue on 09.03.2015\nmy fancy description\n(50 attending (150))\n10 tracks played, total duration 01:15.";
		assertEquals(this.toTest.toString(), out);
  }
  

  
}


