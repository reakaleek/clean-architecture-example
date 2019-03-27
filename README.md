# Clean Architecture
## `entities`
contains the enterprise business entities and
the business rules

## `usecases`
contains the application business rules, view models and interfaces

## `presenter`
is responsible for for mapping the models to view models

## `web`
contains the web mvc framework and the orm because they both
are spring implementations, thus they are in the same package

