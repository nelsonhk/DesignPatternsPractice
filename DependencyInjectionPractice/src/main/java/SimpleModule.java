import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;

public class SimpleModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(IDictionary.class).to(Dictionary.class);
        bind(IURLFetcher.class).to(URLFetcher.class);
        bind(IWordExtractor.class).to(WordExtractor.class);

        // If you want a singleton instance of a class to be bound everywhere it is used
//        bind(SomeClass.class).asEagerSingleton();

        // If you want to bind a specific instance of a class
//        bind(SomeInterface.class).toInstance(new SomeClass());

        // or
//        SomeInterface myInstance = new SomeClass();
//        myInstance.callMethodsToConfigureTheClass();
//        bind(SomeInterface.class).toInstance(myInstance);

    }

    @Provides
    @Named("DictionaryFilePath")
    public String dictionaryFilePath() {
        return "dict.txt";
    }

}
