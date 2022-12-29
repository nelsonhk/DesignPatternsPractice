import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;

public class SimpleModuleTest extends AbstractModule {

    @Override
    protected void configure() {
        //Use Mockito here?
        bind(IDictionary.class).to(TestDictionary.class);
        bind(IURLFetcher.class).to(TestURLFetcher.class);
        bind(IWordExtractor.class).to(TestWordExtractor.class);

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
