package ch.unisg.ics.interactions.wot.td;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ch.unisg.ics.interactions.wot.td.vocabularies.TD;

public class ThingDescriptionTest {
  
  @Test
  public void testTitle() {
    ThingDescription td = (new ThingDescription.Builder("My Thing")).build();
    
    assertEquals("My Thing", td.getTitle());
  }
  
  @Test
  public void testURI() {
    ThingDescription td = (new ThingDescription.Builder("My Thing"))
        .addThingURI("http://example.org/#thing")
        .build();
    
    assertEquals("http://example.org/#thing", td.getThingURI().get());
  }
  
  @Test
  public void testOneType() {
    ThingDescription td = (new ThingDescription.Builder("My Thing"))
        .addSemanticType("http://w3id.org/eve#Artifact")
        .build();
    
    assertEquals(1, td.getSemanticTypes().size());
    assertTrue(td.getSemanticTypes().contains("http://w3id.org/eve#Artifact"));
  }
  
  @Test
  public void testMultipleTypes() {
    ThingDescription td = (new ThingDescription.Builder("My Thing"))
        .addSemanticType(TD.Thing.stringValue())
        .addSemanticType("http://w3id.org/eve#Artifact")
        .addSemanticType("http://iot-schema.org/eve#Light")
        .build();
    
    assertEquals(3, td.getSemanticTypes().size());
    assertTrue(td.getSemanticTypes().contains(TD.Thing.stringValue()));
    assertTrue(td.getSemanticTypes().contains("http://w3id.org/eve#Artifact"));
    assertTrue(td.getSemanticTypes().contains("http://iot-schema.org/eve#Light"));
  }
  
  @Test
  public void testBaseURI() {
    ThingDescription td = (new ThingDescription.Builder("My Thing"))
        .addThingURI("http://example.org/#thing")
        .addBaseURI("http://example.org/")
        .build();
    
    assertEquals("http://example.org/", td.getBaseURI().get());
  }
}
