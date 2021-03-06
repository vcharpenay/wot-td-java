package ch.unisg.ics.interactions.wot.td.schemas;

import java.util.HashSet;
import java.util.Set;

public class DataSchema {
  public static final String OBJECT = "object";
  public static final String ARRAY = "array";
  
  public static final String STRING = "string";
  public static final String NUMBER = "number";
  public static final String INTEGER = "integer";
  public static final String BOOLEAN = "boolean";
  public static final String NULL = "null";
  
  private String datatype;
  private Set<String> semanticTypes;
  
  protected DataSchema(String datatype, Set<String> semanticTypes) {
    this.datatype = datatype;
    this.semanticTypes = semanticTypes;
  }
  
  public String getDatatype() {
    return datatype;
  }
  
  public Set<String> getSemanticTypes() {
    return semanticTypes;
  }
  
  public static abstract class Builder<T extends DataSchema, S extends Builder<T,S>> {
    protected Set<String> semanticTypes;
    
    protected Builder() {
      this.semanticTypes = new HashSet<String>();
    }
    
    @SuppressWarnings("unchecked")
    public S addSemanticType(String type) {
      this.semanticTypes.add(type);
      return (S) this;
    }
    
    @SuppressWarnings("unchecked")
    public S addSemanticTypes(Set<String> type) {
      this.semanticTypes.addAll(type);
      return (S) this;
    }
    
    public abstract T build();
  }
}
