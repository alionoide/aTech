# aTech

## Todo
- Skill tree thing
  - Some way of adding / removing skills
    - Nano injection?
      - Custom registery?
    - Made at some workstation
      - Could just be the workstation?
  - Instability 
    - Soft cap on how many can be used
  - Maybe cool to have something like Luciferium (Ref: RimWorld)
- Alienium
  - Tiered resource
    - 3-5 tiers
      - Each has different properties / uses
      - Tier 1
        - Drops from ore
        - Smelt in furnace
      - Tier 2 
        - Combine T1 with diamond dust
        - Diamond dust comes from custom machine
          - Need to figure out how to open menu
          - Process items
          - more [probably]
    - Increasingly difficult refining
    - All comes from the same base resource?
      - Maybe different harvesting methods?
        - Quick oxidation so maybe needs airtighness?
          - Maybe just for higher yield
  - Comes from meteors?
    - Outer airtight shell, but otherwise porous rock
    - Potentially different meteors are better for different kinds of the ore
      - Could have a variety that has been deeply buried 
        - By lava or otherwise deep underground
  - Could the player name the item?
- Tutorial book
  - Would be cool to have some ThaumCraft style research system
- Different enchanting table
  - Uses chiseled bookshelves
  - Gets enchantments from enchanted books placed in them
    - Certain minimums
    - 15 total / 3 for target item


Installation information
=======

This template repository can be directly cloned to get you started with a new
mod. Simply create a new repository cloned from this one, by following the
instructions at [github](https://docs.github.com/en/repositories/creating-and-managing-repositories/creating-a-repository-from-a-template).

Once you have your clone, simply open the repository in the IDE of your choice. The usual recommendation for an IDE is either IntelliJ IDEA or Eclipse.

> **Note**: For Eclipse, use tasks in `Launch Group` instead of ones founds in `Java Application`. A preparation task must run before launching the game. NeoGradle uses launch groups to do these subsequently.

If at any point you are missing libraries in your IDE, or you've run into problems you can
run `gradlew --refresh-dependencies` to refresh the local cache. `gradlew clean` to reset everything 
{this does not affect your code} and then start the process again.

Mapping Names:
============
By default, the MDK is configured to use the official mapping names from Mojang for methods and fields 
in the Minecraft codebase. These names are covered by a specific license. All modders should be aware of this
license. For the latest license text, refer to the mapping file itself, or the reference copy here:
https://github.com/NeoForged/NeoForm/blob/main/Mojang.md

Additional Resources: 
==========
Community Documentation: https://docs.neoforged.net/  
NeoForged Discord: https://discord.neoforged.net/
