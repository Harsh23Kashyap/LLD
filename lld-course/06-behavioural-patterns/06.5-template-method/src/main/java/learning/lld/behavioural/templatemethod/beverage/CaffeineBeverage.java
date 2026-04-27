package learning.lld.behavioural.templatemethod.beverage;

public abstract class CaffeineBeverage {

    public final void prepareRecipe() {
        // prepareRecipe
    }

    private void boilWater() {
        // boilWater
    }

    // brew
    protected abstract void brew();

    private void pourInCup() {
        // pourInCup
    }

    // addCondiments
    protected abstract void addCondiments();
}
