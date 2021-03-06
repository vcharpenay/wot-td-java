package ch.unisg.ics.interactions.wot.td.affordances;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import ch.unisg.ics.interactions.wot.td.schemas.DataSchema;

/**
 * TODO: add javadoc
 * 
 * @author Andrei Ciortea
 *
 */
public class ActionAffordance extends InteractionAffordance {
  // TODO: currently Schema just holds an RDF graph
  private Optional<DataSchema> input;
  private Optional<DataSchema> output;
  
  // TODO: add safe, idempotent
  
  protected ActionAffordance(Optional<String> title, List<String> types, List<Form> forms, 
      Optional<DataSchema> input, Optional<DataSchema> output) {
    
    super(title, types, forms);
    this.input = input;
    this.output = output;
  }
  
  public Optional<DataSchema> getInputSchema() {
    return input;
  }
  
  public Optional<DataSchema> getOutputSchema() {
    return output;
  }
  
  public static class Builder 
      extends InteractionAffordance.Builder<ActionAffordance, ActionAffordance.Builder> {
    
    private Optional<DataSchema> inputSchema;
    private Optional<DataSchema> outputSchema;
    
    public Builder(List<Form> forms) {
      super(forms);
      
      this.inputSchema = Optional.empty();
      this.outputSchema = Optional.empty();
    }
    
    public Builder(Form form) {
      this(new ArrayList<Form>(Arrays.asList(form)));
    }
    
    public Builder addInputSchema(DataSchema inputSchema) {
      this.inputSchema = Optional.of(inputSchema);
      return this;
    }
    
    public Builder addOutputSchema(DataSchema outputSchema) {
      this.outputSchema = Optional.of(outputSchema);
      return this;
    }
    
    public ActionAffordance build() {
      return new ActionAffordance(this.title, this.types, this.forms, inputSchema, outputSchema);
    }
  }
}
